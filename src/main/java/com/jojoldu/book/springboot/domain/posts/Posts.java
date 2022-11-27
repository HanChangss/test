package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@NoArgsConstructor // 기본생성자 자동추가 public Posts() {}와 같은 효과
@Entity //테이블과 링크될 클래스임을 나타냅니다. 언더스코어 네이밍을 사용 ex- SalesManager.java -> sales_manager table
@EntityListeners(AuditingEntityListener.class)
// @CreatedDate @LastModifiedDate 어노테이션을 단 Column을 다른 클래스에서 extends로 가져올 경우 (BaseEntity 클래스 등 ..) 해당 클래스에 위 어노테이션을 삽입해줘야 한다
public class Posts extends BaseTimeEntity {

    @Id // PK를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false) //컬럼을 나타냄
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
