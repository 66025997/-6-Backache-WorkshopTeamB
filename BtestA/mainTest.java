package BtestA;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class mainTest {

    @Test
    void testCalculateAgeValid() {
        // ทดสอบกรณีปีเกิดที่ถูกต้อง
        int yearOfBirth = 2005;
        int expectedAge = 19; // 2024 - 2005
        assertEquals(expectedAge, main.calcuateAge(yearOfBirth));
    }

    @Test
    void testCalculateAgeInvalid() {
        // ทดสอบกรณีปีเกิดในอนาคต
        int yearOfBirth = 2025;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            main.calcuateAge(yearOfBirth);
        });
        assertEquals("Invalid year of birth", exception.getMessage());
    }

    @Test
    void testCalculateGrade() {
        // ทดสอบการคำนวณเกรด
        assertEquals("A", main.calculateGrade(85));
        assertEquals("B+", main.calculateGrade(77));
        assertEquals("B", main.calculateGrade(72));
        assertEquals("C+", main.calculateGrade(67));
        assertEquals("C", main.calculateGrade(60));
        assertEquals("D+", main.calculateGrade(58));
        assertEquals("D", main.calculateGrade(50));
        assertEquals("F", main.calculateGrade(40));
    }

    @Test
    void testCreateFile() throws IOException {
        // ทดสอบการสร้างไฟล์
        String name = "Tonkla";
        int age = 19;
        String grade = "A";

        // เรียกใช้งานฟังก์ชันสร้างไฟล์
        main.createFile(name, age, grade);

        // ตรวจสอบว่าไฟล์ถูกสร้างแล้ว
        File file = new File("c:/Output/Textfile.txt");
        assertTrue(file.exists(), "File was not created");

        // ตรวจสอบเนื้อหาในไฟล์
        String expectedContent = "Name : Tonkla\nAge : 19\nSoftware Testing Grade : A";
        String actualContent = new String(Files.readAllBytes(Paths.get("c:/Output/Textfile.txt")));
        assertEquals(expectedContent, actualContent);

        // ลบไฟล์หลังทดสอบ
        file.delete();
    }
}
