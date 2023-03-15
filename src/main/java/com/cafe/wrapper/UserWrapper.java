package com.cafe.wrapper;

import com.cafe.POJO.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Data - táto anotácia sa nám stara o gettery a settery, čiže nemusíme ich vobec pisat a vieme ich pouziť
@NoArgsConstructor
//@NoArgsConstructor sa mi zase postará o bezparametrický konštruktor, nemusím ho vytvárať
public class UserWrapper {

    private Integer id;
    private String name;
    private String email;
    private String contactNumber;
    private String status;

    public UserWrapper(Integer id, String name, String email, String contactNumber, String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.status = status;
    }


}
