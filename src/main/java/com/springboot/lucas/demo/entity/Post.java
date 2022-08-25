package com.springboot.lucas.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tb_post")
public class Post implements Serializable {
    private static final long serialVersionUID = 1L; 

    @Id //assim que eu gero valores para string aleatorio(utilizo o gerador de UUID)
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    private String text;

    @ManyToOne //Muitos para um(muitos post para um user); AQUI EU RECEBO MEU USER E POR ISSO ELE NÂO É UMA LISTA
    @JoinColumn(name = "user_id")//chave estrangeira(como coluna) do id user(não é o id de user mas sim uma cópia dele na tabela de post)
    private User user;

    public Post(){
    }

    public Post(String id, String text, User user){
        this.id = id;
        this.text = text;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}