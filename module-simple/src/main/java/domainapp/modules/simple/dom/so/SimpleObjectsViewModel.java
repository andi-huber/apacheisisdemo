package domainapp.modules.simple.dom.so;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.value.Blob;
import org.apache.isis.applib.value.Clob;
import org.apache.isis.applib.value.NamedWithMimeType;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@DomainObject(nature = Nature.VIEW_MODEL,logicalTypeName = "simple.SoViewModel")
@XmlRootElement(name = "SoViewModel")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class SimpleObjectsViewModel {
    @XmlTransient
    @Collection
    public List<SimpleObject> getSimpleObjectList(){
        return simpleObjects.listAll();
    }

    @Autowired
    @XmlTransient
    private SimpleObjects simpleObjects;


    @Action(
            semantics = SemanticsOf.NON_IDEMPOTENT_ARE_YOU_SURE,
            choicesFrom = "simpleObjectList"
    )
    @ActionLayout(
            associateWith = "simpleObjectList"
    )
    public Blob downloadSelected(List<SimpleObject> simpleObjectList, String fileName) throws IOException {
        return downloadFile(simpleObjectList, fileName);
    }

    public String default1DownloadSelected() {
        return "test-" + nowToString();
    }



    public static Blob downloadFile(List<SimpleObject> simpleObjectList, String fileName) throws IOException {
        String testContent = "testtest---" + simpleObjectList.get(0).getName();
        return Clob.of(fileName, NamedWithMimeType.CommonMimeType.TXT, testContent)
                .toBlob(StandardCharsets.UTF_8);
    }

    public static String nowToString() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"));
    }
}
