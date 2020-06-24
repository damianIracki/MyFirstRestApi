package pl.damianIracki.myFirstRestApi.contoller.dto;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Builder
public class PostDto {

    @Id
    private long id;
    private String title;
    private String content;
    private LocalDateTime created;

}
