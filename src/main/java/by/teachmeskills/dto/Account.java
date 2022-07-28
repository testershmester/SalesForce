package by.teachmeskills.dto;

import lombok.*;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Account {

    private String accountName;
    private String webSite;
    private String type;
}
