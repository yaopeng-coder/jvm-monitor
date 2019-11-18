package cn.hust.jvmmonitor.chapter4;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

@BTrace
public class PrintSame {

	/**
	 * 拦截同名函数 根据参数来区分
	 * @param pcn
	 * @param pmn
	 * @param id
	 */
	@OnMethod(
	        clazz="cn.hust.jvmmonitor.chapter4.Ch4Controller",
	        method="same"
	)
	public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn,String name , int id) {
		BTraceUtils.println(pcn+","+pmn + "," + name + id);
		BTraceUtils.println();
    }
}
