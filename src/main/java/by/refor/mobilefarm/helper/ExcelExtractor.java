package by.refor.mobilefarm.helper;

//@Component
public class ExcelExtractor {

//    private final FeedRepository feedRepository;
//    private final NutrientsRepository nutrientsRepository;
//
//    private final GeneticGroupRepository geneticGroupRepository;
//
//    public ExcelExtractor(FeedRepository feedRepository,
//                          NutrientsRepository nutrientsRepository,
//                          GeneticGroupRepository geneticGroupRepository){
//        this.feedRepository = feedRepository;
//        this.nutrientsRepository = nutrientsRepository;
//        this.geneticGroupRepository = geneticGroupRepository;
//    }
//
//   // @PostConstruct
//    public void initNutrients() throws Exception{
//        FileInputStream file = new FileInputStream(new File("feeds.xlsx"));
//
//        //Create Workbook instance holding reference to .xlsx file
//        XSSFWorkbook workbook = new XSSFWorkbook(file);
//
//        //Get first/desired sheet from the workbook
//        XSSFSheet sheet = workbook.getSheetAt(0);
//
//        //Iterate through each rows one by one
//        Iterator<Row> rowIterator = sheet.iterator();
//        while (rowIterator.hasNext()) {
//
//            Row row = rowIterator.next();
//            FeedEntity fe = new FeedEntity()
//                    .setName(row.getCell(1).getStringCellValue())
//                    .setType(row.getCell(2).getStringCellValue());
//            NutrientsEntity ne = new NutrientsEntity()
//                    .setFeedUnit(BigDecimal.valueOf(row.getCell(3).getNumericCellValue()))
//                    .setEnergyExchange(BigDecimal.valueOf(row.getCell(4).getNumericCellValue()))
//                    .setDryMatter(BigDecimal.valueOf(row.getCell(5).getNumericCellValue()))
//                    .setDryProtein(BigDecimal.valueOf(row.getCell(6).getNumericCellValue()))
//                    .setDigestedProtein(BigDecimal.valueOf(row.getCell(7).getNumericCellValue()))
//                    .setRawFat(BigDecimal.valueOf(row.getCell(8).getNumericCellValue()))
//                    .setRawFiber(BigDecimal.valueOf(row.getCell(9).getNumericCellValue()))
//                    .setStarch(BigDecimal.valueOf(row.getCell(10).getNumericCellValue()))
//                    .setSugar(BigDecimal.valueOf(row.getCell(11).getNumericCellValue()))
//                    .setLysine(BigDecimal.valueOf(row.getCell(12).getNumericCellValue()))
//                    .setMethionineAndCystitis(BigDecimal.valueOf(row.getCell(13).getNumericCellValue()))
//                    .setCalcium(BigDecimal.valueOf(row.getCell(14).getNumericCellValue()))
//                    .setPhosphorus(BigDecimal.valueOf(row.getCell(15).getNumericCellValue()))
//                    .setMagnesium(BigDecimal.valueOf(row.getCell(16).getNumericCellValue()))
//                    .setPotassium(BigDecimal.valueOf(row.getCell(17).getNumericCellValue()))
//                    .setSulfur(BigDecimal.valueOf(row.getCell(18).getNumericCellValue()))
//                    .setFerrum(BigDecimal.valueOf(row.getCell(19).getNumericCellValue()))
//                    .setCopper(BigDecimal.valueOf(row.getCell(20).getNumericCellValue()))
//                    .setZins(BigDecimal.valueOf(row.getCell(21).getNumericCellValue()))
//                    .setManganese(BigDecimal.valueOf(row.getCell(22).getNumericCellValue()))
//                    .setCobalt(BigDecimal.valueOf(row.getCell(23).getNumericCellValue()))
//                    .setIodine(BigDecimal.valueOf(row.getCell(24).getNumericCellValue()))
//                    .setCarotene(BigDecimal.valueOf(row.getCell(25).getNumericCellValue()))
//                    .setVitaminE(BigDecimal.valueOf(row.getCell(26).getNumericCellValue()))
//                    .setVitaminD(BigDecimal.valueOf(row.getCell(27).getNumericCellValue()));
//            nutrientsRepository.save(ne);
//            fe.setNutrients(ne);
//            feedRepository.save(fe);
//        }
//        file.close();
//
//
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
//        while (rowIterator1.hasNext()) {
//
//            Row row = rowIterator1.next();
//            GeneticGroupEntity gge = new GeneticGroupEntity()
//                    .setType(row.getCell(1).getStringCellValue());
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
