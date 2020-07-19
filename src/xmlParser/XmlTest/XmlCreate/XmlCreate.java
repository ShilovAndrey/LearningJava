package xmlParser.XmlTest.XmlCreate;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class XmlCreate {

    public static void main(String[] args) throws ParserConfigurationException, TransformerException, FileNotFoundException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        Element rootElement = doc.createElement("company");
        doc.appendChild(rootElement);
        Element companyName = doc.createElement("company_name");
        Text compNameText = doc.createTextNode("Andrey Industries");
        rootElement.appendChild(companyName);
        companyName.appendChild(compNameText);
        Element departments = doc.createElement("departments");
        rootElement.appendChild(departments);
        Element department = doc.createElement("department");
        department.setAttribute("dept_name", "administration");
        departments.appendChild(department);
        Element employee = doc.createElement("employee");
        employee.setAttribute("id_number", "1");
        departments.appendChild(employee);
        Element name = doc.createElement("name");
        Text nameText = doc.createTextNode("Shilov Andrey");
        name.appendChild(nameText);
        employee.appendChild(name);
        Element age = doc.createElement("age");
        Text ageText = doc.createTextNode("32");
        age.appendChild(ageText);
        employee.appendChild(age);
        Element gender = doc.createElement("gender");
        Text genderText = doc.createTextNode("g");
        gender.appendChild(genderText);
        employee.appendChild(gender);
        Element salary = doc.createElement("salary");
        salary.setAttribute("currency", "doll");
        Text salaryText = doc.createTextNode("20000");
        salary.appendChild(salaryText);
        employee.appendChild(salary);

        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream("XML_write.xml")));
    }
}
