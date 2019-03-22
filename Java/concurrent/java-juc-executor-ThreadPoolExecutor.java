---------------------------
ThreadPoolExecutor			|
---------------------------
	# �̳߳ص�ʵ��
	# ���췽��
		ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,BlockingQueue<Runnable> workQueue)
		ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,BlockingQueue<Runnable> workQueue,RejectedExecutionHandler handler)
		ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,BlockingQueue<Runnable> workQueue,ThreadFactory threadFactory)
		ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,BlockingQueue<Runnable> workQueue,ThreadFactory threadFactory,RejectedExecutionHandler handler)

		* corePoolSize
			* �̳߳ػ������߳�����
			* һ���̳߳ؿ�ʼʱ��û���̵߳�,ֻ�е��������˲����߳�����С��corePoolSize�Żᴴ���߳�

		* maximumPoolSize
			* �̳߳�����߳�����
		* keepAliveTime
			* �߳̿��к�Ĵ��ʱ��
		* unit
			*  ���ʱ��ĵ�λ
		* workQueue
			* ����������������
		* threadFactory
			* �̳߳ع�����
		* handler
			* ���̳߳��޷�����������ʱ�Ĵ���handler
		
	# ʵ������
		void allowCoreThreadTimeOut(boolean value)
		boolean allowsCoreThreadTimeOut()
		int getCorePoolSize()
		boolean awaitTermination(long timeout, TimeUnit unit)

		
		int getActiveCount()
		long getCompletedTaskCount()
		long getKeepAliveTime(TimeUnit unit)
		int getLargestPoolSize()
		int getMaximumPoolSize()
		int getPoolSize()
		BlockingQueue<Runnable> getQueue()
		RejectedExecutionHandler getRejectedExecutionHandler()
		long getTaskCount()
		ThreadFactory getThreadFactory()
		boolean isTerminated()
			* ��������е��������񶼴�����Ϻ󷵻� true

		boolean isTerminating() 
		int prestartAllCoreThreads()
		boolean prestartCoreThread()
		void purge()
		boolean remove(Runnable task)
		void setCorePoolSize(int corePoolSize)
		void setKeepAliveTime(long time, TimeUnit unit)
		void setMaximumPoolSize(int maximumPoolSize)
		void setRejectedExecutionHandler(RejectedExecutionHandler handler) 
		void setThreadFactory(ThreadFactory threadFactory)

		boolean isShutdown()
		void shutdown()
			* ��ȵ�����������ɲŻ�ر�

		List<Runnable> shutdownNow()
			* �����ر��̳߳�
			* ������ִ�е�����ȫ������interrupt(),ִֹͣ��
			* �Ի�δ��ʼִ�е�����ȫ��ȡ��,���ҷ��ػ�û��ʼ�������б�

		void execute(Runnable command)
		Future<?> submit(Runnable task)
			* ִ������,submit���Ի�ȡ��ִ�н���ķ���ֵ���׳����쳣

		<T> Future<T> submit(Runnable task, T result)
		<T> Future<T> submit(Callable<T> task)
		<T> T invokeAny(Collection<? extends Callable<T>> tasks,long timeout, TimeUnit unit)
		<T> T invokeAny(Collection<? extends Callable<T>> tasks)
		<T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks,long timeout, TimeUnit unit)
		<T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
	
	# �ڲ���
		* ���Ƕ��� ThreadPoolExecutor ��ʵ����,�������̳߳��޷�ִ��������ʱ�����

		AbortPolicy
			* �޷�����ʱ�׳��쳣
			* Դ��
				public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
					throw new RejectedExecutionException("Task " + r.toString() + " rejected from " +  e.toString());
		        }

		CallerRunsPolicy
			* ֱ������������
			* Դ��
				public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
					if (!e.isShutdown()) {
						r.run();
					}
				}

		DiscardOldestPolicy
			* �������������ϵ�����
			* Դ��
				public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
					if (!e.isShutdown()) {
						e.getQueue().poll();
						e.execute(r);
					}
				}

		DiscardPolicy
			* ����������
			* Դ��
				public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
				}

---------------------------
RejectedExecutionHandler   |
---------------------------
	# ThreadPoolExecutor �޷�����������ʱ�Ĵ���Handler �ӿ�
	# ���󷽷�
		void rejectedExecution(Runnable r, ThreadPoolExecutor executor);