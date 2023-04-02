package com.example.exercise.entity;


import com.example.exercise.dto.talent.TalentCommentRequestDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class TalentComment extends TimeStamped{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;

  @JoinColumn
  @ManyToOne
  private User user;

  @JoinColumn
  @ManyToOne
  private Talent talent;

  @Column(nullable = false)
  private String content;

  public TalentComment(User user, Talent talent, TalentCommentRequestDto requestDto) {
    this.user = user;
    this.talent = talent;
    this.content = requestDto.getContent();
  }

  public void updateTalentComment(String content){
    this.content = content;
  }



}
