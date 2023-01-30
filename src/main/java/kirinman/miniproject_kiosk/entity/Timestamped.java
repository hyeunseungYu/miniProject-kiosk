package kirinman.miniproject_kiosk.entity;


import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Timestamped {


//    @CreatedDate
    @Column(updatable = false)
    private String createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd/hh/mm"));

    //수정시간은 필요없기 때문에 주석처리 하였습니다.
    //남겨두니까 코드 작성할때 헷갈리네요 ㅠ
//    @LastModifiedDate
//    @Column
//    private LocalDateTime modifiedAt;
}