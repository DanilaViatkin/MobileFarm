package by.refor.mobilefarm.helper;

import by.refor.mobilefarm.model.entity.FeedEntity;
import by.refor.mobilefarm.model.entity.FeedGroupEntity;
import by.refor.mobilefarm.model.entity.NutrientsEntity;
import by.refor.mobilefarm.repo.FeedGroupRepository;
import by.refor.mobilefarm.repo.FeedRepository;
import by.refor.mobilefarm.repo.NutrientsRepository;
import jakarta.annotation.PostConstruct;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Objects;

//@Component
public class ExcelExtractor {
//
//    private final FeedRepository feedRepository;
//    private final NutrientsRepository nutrientsRepository;
//
//    private final FeedGroupRepository geneticGroupRepository;
//
//    public ExcelExtractor(FeedRepository feedRepository,
//                          NutrientsRepository nutrientsRepository,
//                          FeedGroupRepository geneticGroupRepository){
//        this.feedRepository = feedRepository;
//        this.nutrientsRepository = nutrientsRepository;
//        this.geneticGroupRepository = geneticGroupRepository;
//    }
//
//    @PostConstruct
//    public void initNutrients() throws Exception{
//        int b = 1;
//        while(b < 732){
//            b++;
//            NutrientsEntity ne = new NutrientsEntity();
//            nutrientsRepository.save(ne);
//        }
//        FileInputStream file1 = new FileInputStream(new File("geneticGroups.xlsx"));
//
//        //Create Workbook instance holding reference to .xlsx file
//        XSSFWorkbook workbook1 = new XSSFWorkbook(file1);
//
//        //Get first/desired sheet from the workbook
//        XSSFSheet sheet1 = workbook1.getSheetAt(0);
//
//        //Iterate through each rows one by one
//        Iterator<Row> rowIterator1 = sheet1.iterator();
//        int i = 1;
//        while (rowIterator1.hasNext() && i < 183) {
//            i++;
//            Row row = rowIterator1.next();
//
//            FeedGroupEntity gge = new FeedGroupEntity()
//                    .setType(row.getCell(0).getStringCellValue())
//                    .setAgeFrom(row.getCell(27).getCellType() != CellType.BLANK ? (int)row.getCell(27).getNumericCellValue() : null)
//                    .setAgeTo(row.getCell(28).getCellType() != CellType.BLANK ? (int)row.getCell(28).getNumericCellValue() : null)
//                    .setLactationFrom(row.getCell(29).getCellType() != CellType.BLANK ? (int)row.getCell(29).getNumericCellValue() : null)
//                    .setLactationTo(row.getCell(30).getCellType() != CellType.BLANK ? (int)row.getCell(30).getNumericCellValue() : null)
//                    .setProductivity(row.getCell(31).getCellType() != CellType.BLANK ? BigDecimal.valueOf(row.getCell(31).getNumericCellValue()) : null)
//                    .setGeneticProductivity(row.getCell(32).getCellType() != CellType.BLANK ? BigDecimal.valueOf(row.getCell(32).getNumericCellValue()) : null)
//                    .setWeight(row.getCell(33).getCellType() != CellType.BLANK ? BigDecimal.valueOf(row.getCell(33).getNumericCellValue()) : null)
//                    .setGeneticWeight(row.getCell(34).getCellType() != CellType.BLANK ? BigDecimal.valueOf(row.getCell(34).getNumericCellValue()) : null)
//                    .setAverageDailyGain(row.getCell(35).getCellType() != CellType.BLANK ? (int)row.getCell(35).getNumericCellValue() : null);
//            NutrientsEntity nee = new NutrientsEntity()
//                    .setFeedUnit(BigDecimal.valueOf(row.getCell(3).getNumericCellValue()))
//                    .setEnergyExchange(BigDecimal.valueOf(row.getCell(4).getNumericCellValue()))
//                    .setDryMatter(BigDecimal.valueOf(row.getCell(5).getNumericCellValue()))
//                    .setDryProtein(BigDecimal.valueOf(row.getCell(6).getNumericCellValue()))
//                    .setDigestedProtein(BigDecimal.valueOf(row.getCell(7).getNumericCellValue()))
//                    .setRawFat(BigDecimal.valueOf(row.getCell(8).getNumericCellValue()))
//                    .setRawFiber(BigDecimal.valueOf(row.getCell(9).getNumericCellValue()))
//                    .setStarch(BigDecimal.valueOf(row.getCell(10).getNumericCellValue()))
//                    .setSugar(BigDecimal.valueOf(row.getCell(11).getNumericCellValue()))
//                    .setCalcium(BigDecimal.valueOf(row.getCell(12).getNumericCellValue()))
//                    .setPhosphorus(BigDecimal.valueOf(row.getCell(13).getNumericCellValue()))
//                    .setMagnesium(BigDecimal.valueOf(row.getCell(14).getNumericCellValue()))
//                    .setPotassium(BigDecimal.valueOf(row.getCell(15).getNumericCellValue()))
//                    .setSulfur(BigDecimal.valueOf(row.getCell(16).getNumericCellValue()))
//                    .setFerrum(BigDecimal.valueOf(row.getCell(17).getNumericCellValue()))
//                    .setCopper(BigDecimal.valueOf(row.getCell(18).getNumericCellValue()))
//                    .setZins(BigDecimal.valueOf(row.getCell(19).getNumericCellValue()))
//                    .setManganese(BigDecimal.valueOf(row.getCell(20).getNumericCellValue()))
//                    .setCobalt(BigDecimal.valueOf(row.getCell(21).getNumericCellValue()))
//                    .setIodine(BigDecimal.valueOf(row.getCell(22).getNumericCellValue()))
//                    .setCarotene(BigDecimal.valueOf(row.getCell(23).getNumericCellValue()))
//                    .setVitaminE(BigDecimal.valueOf(row.getCell(24).getNumericCellValue()))
//                    .setVitaminD(BigDecimal.valueOf(row.getCell(25).getNumericCellValue()))
//                    .setSalt(BigDecimal.valueOf(row.getCell(26).getNumericCellValue()));
//            //nutrientsRepository.save(nee);
//            gge.setNutrients(nee);
//            geneticGroupRepository.save(gge);
//            System.out.println(gge);
//        }
//        file1.close();
//    }
}
