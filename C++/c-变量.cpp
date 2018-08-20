

----------------------------------------
变量									|
----------------------------------------
	# 变量的类型与内存大小
		int
			* 系统给定的基本整数类型,C规定不能小于16位
		long
		short
		unsigned
		signed
		char
		float
		double
		void

		_Bool
		_Complex
		_Imaginary
	
	# 常量默认类型
		* 数字通常以 int 类型表示,如果超出了 int 类型,编译器会先视其为 long int 类型
		* 如果超出了 long 可表示的最大值,编译器则视其为 unsigned long 类型
		* 如果还不不够大,编译器则将其视为 long long 或者 unsigned long long 类型
		* 前提是编译器能够识别这些类型
	
		* 八进制,十六进制也被视为 int 类型
		* 如果值太大,编译器会尝试使用 unsigned int ,long ,unsigned long ,long long ,unsigned long 类型
		
	
	# 指定常量数据类型
		* 在值后面添加L/l表示该常量是 long 数据类型
			15L;
		
		* 在职后天添加LL/ll表示该常量是 long long 数据类型
			15LL

		* 添加f/F后缀,是 float 的常量声明
			0.23F

		* 添加 u/U后缀 是 unsgined 常量类型声明
			5u
			5UL
			5ULL
	
	# 整数溢出
		* 无符号整数溢出,它的值会变成0
		* 有符号整数,如果是负数,那么它的值会变成 -2147483648,如果是正数,那么会变成0
	
	# 浮点数溢出
	
	# 16 进制与 8 进制
		0xFF
		0457
	

----------------------------------------
变量声明								|
----------------------------------------
	# 合法的声明
		int num,age;

		int num = 1,age = 15;
	
		long int x;
		short int x;
		long int x;
		long long x;
		unsigned long;
		long double;

----------------------------------------
bool 类型								|
----------------------------------------
	# C语言中使用 0 表示 false,非 0 表示 true
	# C99提供了 #include<stdbool.h> 头文件,使C增加了 bool 关键字和 true / false 关键字
		bool flag = true;
		flag = false;

----------------------------------------
常量声明								|
----------------------------------------
	# 编译时替换常量
		#define name value

		* 在编译程序的时候,程序中的所有 name 都会被替换为 value
		* 这个过程称为编译时替换,在运行程序的时候,所有替换都已经完成
		* 这样定义的常量也被称为明示常量

		* 末尾不需要添加;,而且名称要大写
	
	# const 
		const int X = 5;

		* X 这个变量只读,不能修改


----------------------------------------
typedef 机制							|
----------------------------------------
	# typedef 机制允许开发者为现有的数据类型创建别名
		typedef int my_int;
		my_int num = 15;
		printf("%d",num);

----------------------------------------
可移植类型 stdint.h 和 inttypes.h		|
----------------------------------------
	