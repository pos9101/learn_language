# 2장 스칼라 첫걸음

참조서적 컴파일 환경 
* Scala 2.11.7 

## first

~~~
$scala
scala> 
~~~

~~~
scala> 1 + 2
res0: Int = 3
~~~

~~~
scala> res0 * 3
res1: Int = 9
~~~

~~~
scala> println("Hello, world!")
Hello, world!
~~~

## second : variable

~~~
scala> val msg = "Hello, world!"
msg: String = Hello, world!
~~~

~~~
scala> val msg2: java.lang.String = "Hello again, world!"
msg2: String = Hello again, world!
~~~

~~~
scala> val msg3: String = "Hello yet again, world!"
msg3: String = Hello yet again, world!
~~~

~~~
scala> println(msg)
Hello, world!
~~~

~~~
scala> msg = "Goodbye cruel world!"
<console>:8: error: reassignment to val
		msg = "Goodbye cruel world!"
		    ^
~~~

