package nb.stp.mansco.base.service.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component("beforeLogger")
public class ManagerBeforeLogger implements MethodBeforeAdvice {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(ManagerBeforeLogger.class.getName());

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		logger.info("Method" + target.getClass().getName() + ":" + method.getName() + " will be executed !");
	}

}
