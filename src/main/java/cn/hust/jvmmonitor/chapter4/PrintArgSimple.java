package cn.hust.jvmmonitor.chapter4;


import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

/**
 * btrace测试类
 */
@BTrace
public class PrintArgSimple {

    /**
     * 普通方法拦截
     * @param pcn
     * @param pmn
     * @param args
     */
	@OnMethod(
	        clazz="cn.hust.jvmmonitor.chapter4.Ch4Controller",
	        method="arg1",
	        location=@Location(Kind.ENTRY)
	)
	public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, AnyType[] args) {
		BTraceUtils.printArray(args);
		BTraceUtils.println(pcn+","+pmn);
		BTraceUtils.println();
    }
}
