package uz.ixtiyor21.trello_magic.service.file;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 12.03.2022 9:41
 * Project : Trello_magic
 */
@Service
public class FileUploadService {
    private static final String FILE_UPLOAD_PATH_ORG = "C:\\upload\\etm\\organization\\logos";
    private static final String FILE_UPLOAD_PATH_USER = "C:\\upload\\etm\\user\\logos";
    private static Path rootLocation;

    public FileUploadService() {
        rootLocation = Paths.get(FILE_UPLOAD_PATH_ORG);
    }

    public static String saveOrgImage(MultipartFile file) throws IOException {
        String orgName = file.getOriginalFilename();
        String extension= StringUtils.getFilenameExtension(orgName);
        String generatedName=System.currentTimeMillis()+"."+extension;
        Files.copy(file.getInputStream(),Paths.get(FILE_UPLOAD_PATH_ORG,generatedName), StandardCopyOption.REPLACE_EXISTING);
        return "C:/upload/etm/organization/logos/"+generatedName;
    }

    public static String saveUserImage(MultipartFile file) throws IOException{
        String orgName = file.getOriginalFilename();
        String extension= StringUtils.getFilenameExtension(orgName);
        String generatedName=System.currentTimeMillis()+"."+extension;
        Files.copy(file.getInputStream(),Paths.get(FILE_UPLOAD_PATH_USER,generatedName), StandardCopyOption.REPLACE_EXISTING);
        return "C:/upload/etm/user/logos/"+generatedName;
    }
}
