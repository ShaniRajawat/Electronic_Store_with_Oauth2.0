package com.sr.electronic.store.Electronic_Store.services.implementaions;

import com.sr.electronic.store.Electronic_Store.exceptions.BadApiRequestException;
import com.sr.electronic.store.Electronic_Store.services.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);
    @Override
    public String uploadImage(MultipartFile file, String path) throws IOException {
        String originalFilename = file.getOriginalFilename();
        logger.info("Filename : {}", originalFilename);

        String extension = Objects.requireNonNull(originalFilename).substring(originalFilename.lastIndexOf("."));
        String name = UUID.randomUUID().toString();
        String filenameWithExtension = name + extension;
        String fullPathWithFileName = path + filenameWithExtension;

        logger.info("Full path with name : {}", fullPathWithFileName);

        // Check for allowed file extensions
        if (extension.equals(".jpg")) {

            logger.info("File extension is : {}", extension);

            // Create folder if it doesn't exist
            File folder = new File(path);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            // Check if file already exists and delete it
            File existingFile = new File(fullPathWithFileName);
            if (existingFile.exists()) {
                logger.info("File already exists, deleting the previous file.");
                existingFile.delete();
                logger.info("Deleted Successfully");
            }

            // Upload the new file
            Files.copy(file.getInputStream(), Paths.get(fullPathWithFileName));

            return filenameWithExtension;
        } else {
            throw new BadApiRequestException("Only JPG are allowed not with this " +extension);
        }
    }


    @Override
    public InputStream getResource(String path, String name) throws FileNotFoundException {
        String fullPath = path+File.separator+name;
        return new FileInputStream(fullPath);
    }
}
