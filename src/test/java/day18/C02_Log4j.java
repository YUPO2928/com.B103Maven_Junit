package day18;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class C02_Log4j {


    // 3. Logger object olustur:
    //    private static Logger logger = LogManager.getLogger(Demo1.class.getName());
    // 4. Logger fonksiyonuyla istenilen fonksiyonu kullan
    //        logger.debug("Debug logger");
    //        logger.info("Info logger");
    //        logger.error("Error logger");
    //        logger.fatal("Fatal logger");


    private static Logger logger = LogManager.getLogger(C02_Log4j.class.getName());

    @Test
    public void log4jTest(){

    //logger objesi ile yazdırma işlemini yap.
    logger.fatal("fatal Log!");
    logger.error("Error Log!");
    logger.warn("WarnLog!");
    logger.debug("Debug !");
    logger.info("Info Log!");


    }

}
