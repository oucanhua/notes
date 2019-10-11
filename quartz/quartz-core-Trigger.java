----------------------------
Trigger						|
----------------------------
	# �ӿ��ڲ���ö�ٺͳ���
		public enum TriggerState { NONE, NORMAL, PAUSED, COMPLETE, ERROR, BLOCKED }
		public enum CompletedExecutionInstruction { NOOP, RE_EXECUTE_JOB, SET_TRIGGER_COMPLETE, DELETE_TRIGGER, 
			SET_ALL_JOB_TRIGGERS_COMPLETE, SET_TRIGGER_ERROR, SET_ALL_JOB_TRIGGERS_ERROR }
		public static final int MISFIRE_INSTRUCTION_SMART_POLICY = 0;
		public static final int MISFIRE_INSTRUCTION_IGNORE_MISFIRE_POLICY = -1;
		public static final int DEFAULT_PRIORITY = 5;

	# �ӿڷ���
		public TriggerKey getKey();
		public JobKey getJobKey();
		
		public String getDescription();

		public String getCalendarName();

		public JobDataMap getJobDataMap();
		public int getPriority();

		public boolean mayFireAgain();
		public Date getStartTime();

		public Date getEndTime();

		public Date getNextFireTime();

		public Date getPreviousFireTime();

		public Date getFireTimeAfter(Date afterTime);

		public Date getFinalFireTime();

		public int getMisfireInstruction();
		public TriggerBuilder<? extends Trigger> getTriggerBuilder();
		
		public ScheduleBuilder<? extends Trigger> getScheduleBuilder();

		public boolean equals(Object other);
		
		public int compareTo(Trigger other);


	# ���õ��ӽӿ�
		SimpleTrigger
		CronTrigger
		CalendarIntervalTrigger
		DailyTimeIntervalTrigger

	# ��������(misfire Instructions)
		
----------------------------
TriggerBuilder				|
----------------------------
	# Trigger ������
	
	# ��̬����
		static TriggerBuilder<Trigger> newTrigger()
		
	# ʵ������
		T build()
		TriggerBuilder<T> endAt(Date triggerEndTime)
			* ��ʾtriggerʧЧ��ʱ���

		TriggerBuilder<T> forJob(JobDetail jobDetail)
		TriggerBuilder<T> forJob(JobKey keyOfJobToFire)
		TriggerBuilder<T> forJob(String jobName)
		TriggerBuilder<T> forJob(String jobName, String jobGroup)
		TriggerBuilder<T> modifiedByCalendar(String calName)
			* �������õ�Scheduler�е� Calendar , �޸�ִ�мƻ�

		TriggerBuilder<T> startAt(Date triggerStartTime)
			* ����trigger��һ�δ�����ʱ��

		TriggerBuilder<T> startNow()
			* ������, ������������

		TriggerBuilder<T> usingJobData(JobDataMap newJobDataMap)
		TriggerBuilder<T> usingJobData(String dataKey, Boolean value)
		TriggerBuilder<T> usingJobData(String dataKey, Double value)
		TriggerBuilder<T> usingJobData(String dataKey, Float value)
		TriggerBuilder<T> usingJobData(String dataKey, Integer value)
		TriggerBuilder<T> usingJobData(String dataKey, Long value)
		TriggerBuilder<T> usingJobData(String dataKey, String value)

		TriggerBuilder<T> withDescription(String triggerDescription)

		TriggerBuilder<T> withIdentity(String name)
		TriggerBuilder<T> withIdentity(String name, String group)
		TriggerBuilder<T> withIdentity(TriggerKey triggerKey)
			* name, ��ʾtriggerΨһ������
			* group, ��ʾtrigger�����ķ���
			
			* ���û���� group, Ĭ��Ϊ: DEFAULT

		TriggerBuilder<T> withPriority(int triggerPriority)
			* ���ȼ�, �����Ͼ����������̵߳����ȼ�
			* ���û��Ϊtrigger�������ȼ���triggerʹ��Ĭ�����ȼ���ֵΪ5
			* priority���Ե�ֵ��������������������������������
			* ע�⣺ֻ��ͬʱ������trigger֮��Ż�Ƚ����ȼ���


		<SBT extends T> TriggerBuilder<SBT> withSchedule(ScheduleBuilder<SBT> schedBuilder)
			* �������ȹ���

----------------------------
ScheduleBuilder				|
----------------------------
	# ���ȽӿڵĹ����ӿ�, ���󷽷�
		  protected abstract MutableTrigger build();

	# ����
		CalendarIntervalScheduleBuilder
		CronScheduleBuilder
		DailyTimeIntervalScheduleBuilder
		SimpleScheduleBuilder


----------------------------
SimpleTrigger				|
----------------------------
	# �򵥵Ĵ�����, �̶�ʱ�䵥λִ��, ��������ִ�д���
	# ͨ�� SimpleScheduleBuilder ����
	# ��̬��������
		SimpleScheduleBuilder simpleSchedule()

		SimpleScheduleBuilder repeatMinutelyForever()
		SimpleScheduleBuilder repeatMinutelyForever(int minutes)
		SimpleScheduleBuilder repeatSecondlyForever() 
		SimpleScheduleBuilder repeatSecondlyForever(int seconds)
		SimpleScheduleBuilder repeatHourlyForever()
		SimpleScheduleBuilder repeatHourlyForever(int hours)
			* ���ն���ʱ�䵥λ�ظ�ִ��, ʱ�䵥λĬ��1(��/��/ʱ)

		SimpleScheduleBuilder repeatMinutelyForTotalCount(int count)
		SimpleScheduleBuilder repeatMinutelyForTotalCount(int count, int minutes)
		SimpleScheduleBuilder repeatSecondlyForTotalCount(int count)
		SimpleScheduleBuilder repeatSecondlyForTotalCount(int count, int seconds)
		SimpleScheduleBuilder repeatHourlyForTotalCount(int count)
		SimpleScheduleBuilder repeatHourlyForTotalCount(int count, int hours)
			* ���ն���ʱ�䵥λ�ظ�ִ��, ʱ�䵥λĬ��1(��/��/ʱ)
			* count ����ִ�д���

	# ʵ������
		MutableTrigger build()
		SimpleScheduleBuilder withIntervalInMilliseconds(long intervalInMillis)
		SimpleScheduleBuilder withIntervalInMilliseconds(long intervalInMillis)
		SimpleScheduleBuilder withIntervalInSeconds(int intervalInSeconds)
		SimpleScheduleBuilder withIntervalInMinutes(int intervalInMinutes)
		SimpleScheduleBuilder withIntervalInHours(int intervalInHours)
		SimpleScheduleBuilder withRepeatCount(int triggerRepeatCount)
		SimpleScheduleBuilder repeatForever()
		SimpleScheduleBuilder withMisfireHandlingInstructionIgnoreMisfires()
		SimpleScheduleBuilder withMisfireHandlingInstructionFireNow() 
		SimpleScheduleBuilder withMisfireHandlingInstructionNextWithExistingCount()
		SimpleScheduleBuilder withMisfireHandlingInstructionNextWithRemainingCount()
		SimpleScheduleBuilder withMisfireHandlingInstructionNowWithExistingCount()
		SimpleScheduleBuilder withMisfireHandlingInstructionNowWithRemainingCount()
		


----------------------------
CronTrigger					|
----------------------------
	# Cron����ʽ�ĵ���
	# ͨ�� CronScheduleBuilder ����
	# ��̬��������
		CronScheduleBuilder atHourAndMinuteOnGivenDaysOfWeek(int hour, int minute, Integer... daysOfWeek)
		CronScheduleBuilder cronSchedule(String cronExpression)
		CronScheduleBuilder cronSchedule(CronExpression cronExpression)
		CronScheduleBuilder cronScheduleNonvalidatedExpression(String cronExpression)
		CronScheduleBuilder dailyAtHourAndMinute(int hour, int minute)
		CronScheduleBuilder monthlyOnDayAndHourAndMinute(int dayOfMonth, int hour, int minute)
		CronScheduleBuilder weeklyOnDayAndHourAndMinute(int dayOfWeek, int hour, int minute)

	# ʵ������
		CronScheduleBuilder inTimeZone(TimeZone timezone)
		CronScheduleBuilder withMisfireHandlingInstructionDoNothing()
		CronScheduleBuilder withMisfireHandlingInstructionFireAndProceed()
		CronScheduleBuilder withMisfireHandlingInstructionIgnoreMisfires()

----------------------------
DailyTimeIntervalTrigger	|
----------------------------
	# ͨ�� DailyTimeIntervalScheduleBuilder ����
	# ��̬��������
		DailyTimeIntervalScheduleBuilder dailyTimeIntervalSchedule()

	# ʵ������
		DailyTimeIntervalScheduleBuilder endingDailyAfterCount(int count)
		DailyTimeIntervalScheduleBuilder endingDailyAt(TimeOfDay timeOfDay)
		DailyTimeIntervalScheduleBuilder onDaysOfTheWeek(Integer ... onDaysOfWeek)
		DailyTimeIntervalScheduleBuilder onDaysOfTheWeek(Set<Integer> onDaysOfWeek)
		DailyTimeIntervalScheduleBuilder onEveryDay()
		DailyTimeIntervalScheduleBuilder onMondayThroughFriday()
		DailyTimeIntervalScheduleBuilder onSaturdayAndSunday()
		DailyTimeIntervalScheduleBuilder startingDailyAt(TimeOfDay timeOfDay)
		DailyTimeIntervalScheduleBuilder withInterval(int timeInterval, IntervalUnit unit)
		DailyTimeIntervalScheduleBuilder withIntervalInHours(int intervalInHours)
		DailyTimeIntervalScheduleBuilder withIntervalInMinutes(int intervalInMinutes)
		DailyTimeIntervalScheduleBuilder withIntervalInSeconds(int intervalInSeconds)
		DailyTimeIntervalScheduleBuilder withMisfireHandlingInstructionDoNothing()
		DailyTimeIntervalScheduleBuilder withMisfireHandlingInstructionFireAndProceed()
		DailyTimeIntervalScheduleBuilder withMisfireHandlingInstructionIgnoreMisfires()
		DailyTimeIntervalScheduleBuilder withRepeatCount(int repeatCount)
	
	# TimeOfDay
		* ��Ҫ����ά����3������
			private final int hour;
			private final int minute;
			private final int second;
		
		* ���췽��
			TimeOfDay(int hour, int minute, int second) 
	

----------------------------
CalendarIntervalTrigger		|
----------------------------
	# ͨ�� CalendarIntervalScheduleBuilder ����
	# ��������
		static CalendarIntervalScheduleBuilder calendarIntervalSchedule()
	# ʵ������
		CalendarIntervalScheduleBuilder inTimeZone(TimeZone timezone)
		CalendarIntervalScheduleBuilder preserveHourOfDayAcrossDaylightSavings(boolean preserveHourOfDay)
		CalendarIntervalScheduleBuilder skipDayIfHourDoesNotExist(boolean skipDay)
		CalendarIntervalScheduleBuilder withInterval(int timeInterval, IntervalUnit unit)
		CalendarIntervalScheduleBuilder withIntervalInDays(int intervalInDays)
		CalendarIntervalScheduleBuilder withIntervalInHours(int intervalInHours)
		CalendarIntervalScheduleBuilder withIntervalInMinutes(int intervalInMinutes)
		CalendarIntervalScheduleBuilder withIntervalInMonths(int intervalInMonths)
		CalendarIntervalScheduleBuilder withIntervalInSeconds(int intervalInSeconds)
		CalendarIntervalScheduleBuilder withIntervalInWeeks(int intervalInWeeks)
		CalendarIntervalScheduleBuilder withIntervalInYears(int intervalInYears)
		CalendarIntervalScheduleBuilder withMisfireHandlingInstructionDoNothing()
		CalendarIntervalScheduleBuilder withMisfireHandlingInstructionFireAndProceed()
		CalendarIntervalScheduleBuilder withMisfireHandlingInstructionIgnoreMisfires()
		
----------------------------
TriggerKey					|
----------------------------
	# ����trigger��name��grouo���Զ���
		
	# ��JobKeyһ��һ��, ����������ͬ
