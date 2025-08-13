package uz.pdp.ecommerce.controller;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.ecommerce.entity.Attachment;
import uz.pdp.ecommerce.entity.AttachmentContent;
import uz.pdp.ecommerce.repo.AttachmentContentRepository;
import uz.pdp.ecommerce.repo.AttachmentRepository;

import java.io.IOException;

@RequestMapping("/api/file")
@RestController
@MultipartConfig
@RequiredArgsConstructor
public class AttachmentController {

    private final AttachmentContentRepository attachmentContentRepository;
    private final AttachmentRepository attachmentRepository;

    @GetMapping("/{attachmentId}")
    public void getFile(@PathVariable Integer attachmentId, HttpServletResponse response) throws IOException {
        AttachmentContent attachmentContent = attachmentContentRepository.findByAttachmentId(attachmentId);
        response.getOutputStream().write(attachmentContent.getContent());
    }

    @PostMapping
    public Integer uploadFile(@RequestParam MultipartFile file) throws IOException {
        Attachment attachment = Attachment.builder()
                .name(file.getOriginalFilename())
                .build();
        attachmentRepository.save(attachment);

        AttachmentContent attachmentContent = AttachmentContent.builder()
                .content(file.getBytes())
                .attachment(attachment)
                .build();
        attachmentContentRepository.save(attachmentContent);
        return attachmentContent.getId();

    }

}
