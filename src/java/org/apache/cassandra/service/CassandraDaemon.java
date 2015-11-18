
/**
 * This class supports two methods for creating a Cassandra node daemon, 
 * invoking the class's main method, and using the jsvc wrapper from 
 * commons-daemon, (for more information on using this class with the 
 * jsvc wrapper, see the 
 * <a href="http://commons.apache.org/daemon/jsvc.html">Commons Daemon</a>
 * documentation).
 * 
 * 
 */

public class CassandraDaemon
{
    private static Logger logger = Logger.getLogger(CassandraDaemon.class);
    private TThreadPoolServer serverEngine;

    private void setup()
    {
        int listenPort = DatabaseDescriptor.getThriftPort();
        
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
        {
            public void uncaughtException(Thread t, Throwable e)
            {
                logger.error("Fatal exception in thread " + t, e);
            }
        });
        
        CassandraServer peerStorageServer = new CassandraServer();
        peerStorageServer.start();
        Cassandra.Processor processor = new Cassandra.Processor(peerStorageServer);

        TServerSocket tServerSocket = new TServerSocket(new InetSocketAddress(FBUtilities.getHostAddress(), listenPort));
        TProtocolFactory tProtocolFactory = new TBinaryProtocol.Factory();

        TThreadPoolServer.Options options = new TThreadPoolServer.Options();
        options.minWorkerThreads = 64;
        serverEngine = new TThreadPoolServer(new TProcessorFactory(processor),
                                             tServerSocket,
                                             new TTransportFactory(),
                                             new TTransportFactory(),
                                             tProtocolFactory,
                                             tProtocolFactory,
                                             options);
    }

    /** hook for JSVC */
    public void init(String[] args) throws IOException, TTransportException
    {  
        setup();
    }

    public void start()
    {
        serverEngine.serve();
    }

    public void stop()
    {
        serverEngine.stop();
    }
    
    
    public void destroy()
    {        
    }
    
    public static void main(String[] args)
    {
        CassandraDaemon daemon = new CassandraDaemon();
        String pidFile = System.getProperty("cassandra-pidfile");
        
        daemon.setup();

        if (pidFile != null)
        {
            new File(pidFile).deleteOnExit();
        }

        daemon.start();
    }
}
