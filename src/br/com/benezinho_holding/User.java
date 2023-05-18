package br.com.benezinho_holding;

import java.util.Collection;

public class User {
    private Long id;
    private String email;
    private String password;
    public Collection<Profile> profiles;

    public User() {
    }
}
