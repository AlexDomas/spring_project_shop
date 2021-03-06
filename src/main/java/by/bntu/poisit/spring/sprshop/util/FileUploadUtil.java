
package by.bntu.poisit.spring.sprshop.util;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;


public class FileUploadUtil {
    
    private static final String ABS_PATH = "D:\\NetBeansProjects\\sprshop3\\src\\main\\webapp\\assets\\img\\products\\black\\";
    private static String REAL_PATH = "";
    
    private static final Logger logger = LoggerFactory.getLogger(FileUploadUtil.class);

    public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
       
        //get the real path
        REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/img/products/black/");
        
        logger.info(REAL_PATH);
        
        //to make sure all the directory exists
        //please create the directories
        if(!new File(ABS_PATH).exists()){
            
            new File(ABS_PATH).mkdirs();
        }
        
        if(!new File(REAL_PATH).exists()){
            
            new File(REAL_PATH).mkdirs();
        }
        
        try{
            //server upload
            file.transferTo(new File(REAL_PATH + code + ".jpg"));
            //project directory upload
            file.transferTo(new File(ABS_PATH + code + ".jpg"));
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        
    }
    
}
