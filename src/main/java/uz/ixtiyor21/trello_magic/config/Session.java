package uz.ixtiyor21.trello_magic.config;

import uz.ixtiyor21.trello_magic.entity.auth.AuthUser;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 05.03.2022 22:49
 * Project : Trello_magic
 */
public class Session {
    private static AuthUser session;

    public static void setSession(AuthUser authUser){
        session=authUser;
    }
    public static void setSession(){session=null;}

    public static AuthUser getSession(){return session;}
}
