package imageboard.action;

import java.io.File;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import imageboard.bean.ImageDTO;
import imageboard.dao.ImageDAO;

public class ImageboardWriteAction implements CommandProcess{
    public String requestPro(HttpServletRequest request, HttpServletResponse response) 
            throws Throwable {
        String realFolder=request.getServletContext().getRealPath("/storage");
        System.out.println("실제폴더 = "+realFolder); 
        MultipartRequest multi = new MultipartRequest(request
                                                     , realFolder
                                                     , 5*1024*1024 //5mb
                                                     ,"UTF-8"
                                                     , new DefaultFileRenamePolicy());
        
        String imageId = multi.getParameter("imageId");
        String imageName = multi.getParameter("imageName");
        int imagePrice = Integer.parseInt(multi.getParameter("imagePrice"));
        int imageQty = Integer.parseInt(multi.getParameter("imageQty"));
        String imageContent = multi.getParameter("imageContent");
        String originalFileName = multi.getOriginalFileName("image1");
        String image1 = originalFileName;
        
        File file = multi.getFile("image1");
        
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setImageId(imageId);
        imageDTO.setImageName(imageName);
        imageDTO.setImagePrice(imagePrice);
        imageDTO.setImageQty(imageQty);
        imageDTO.setImageContent(imageContent);
        imageDTO.setImage1(image1);
        
        ImageDAO imageDAO = ImageDAO.getInstance();
        imageDAO.write(imageDTO);
        
        request.setAttribute("display", "/imageboard/imageboardWrite.jsp");
        return "/main/index.jsp";
    }

}
