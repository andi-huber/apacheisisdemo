package domainapp.modules.simple.dom.so;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.Nature;
import org.apache.isis.applib.annotation.Title;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//@DomainObject(nature = Nature.VIEW_MODEL,logicalTypeName = "cps.PetOwnerDto")
//@XmlRootElement(name = "PetOwnerDto")
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(
//    propOrder = {
//            "name",
//            "id",
//            "phoneNumber"
//    }
//)
//@NoArgsConstructor(access = AccessLevel.PUBLIC)
//public class SimpleObjectDto {
//    @Getter @Setter
//    @Title
//    private Long id;
//
//    @Getter
//    @Setter
//    private String name;
//
//    @Getter
//    @Setter
//    private String phoneNumber;
//
//    public SimpleObjectDto(PetOwner petOwner) {
//        this.id = petOwner.getId();
//        this.name = (petOwner.getFirstName() != null ? petOwner.getFirstName() + " ": "")  + petOwner.getLastName();
//        this.phoneNumber = petOwner.getPhoneNumber();
//    }
//}
