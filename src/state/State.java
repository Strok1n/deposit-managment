package state;

import db.DatabaseConnection;
import util.AppDefaultTableModel;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.*;

public class State {

    private static final int tablesNumber = 8;
    public static final Vector<String> tableNames = new Vector<>(Arrays.asList("passport", "client", "currency",
                    "position", "employee", "deposit", "contract", "history"));
    public static Vector<DefaultTableModel> models;

    public static Vector<Vector<String>> textLabels;
    public static Vector<Vector<String>> boxLabels;

    public static Vector<Integer> jTextFieldsNumber;
    public static Vector<Integer> jComboBoxesNumber;

    public static Vector<Vector<Integer>> jComboBoxesFK;




    private static Vector<String> clientData;
    private static Vector<String> employeeData;
    private static Vector<String> adminData;
    private static Vector<Vector<String>> passports;
    private static Vector<String> passportColumns;
    private static DefaultTableModel passportsModel;




    private static void initBoxesFunc(){

    }



    private static void initJFramesConstants(){
        jTextFieldsNumber = new Vector<>();
        jTextFieldsNumber.add(15);
        jTextFieldsNumber.add(5);
        jTextFieldsNumber.add(3);
        jTextFieldsNumber.add(3);
        jTextFieldsNumber.add(7);
        jTextFieldsNumber.add(6);
        jTextFieldsNumber.add(8);
        jTextFieldsNumber.add(3);
        jComboBoxesNumber = new Vector<>();
        jComboBoxesNumber.add(0);
        jComboBoxesNumber.add(1);
        jComboBoxesNumber.add(0);
        jComboBoxesNumber.add(1);
        jComboBoxesNumber.add(2);
        jComboBoxesNumber.add(1);
        jComboBoxesNumber.add(3);
        jComboBoxesNumber.add(1);
        jComboBoxesFK = new Vector<>();
        for (int i = 0; i != jComboBoxesNumber.size(); i++)
            jComboBoxesFK.add(new Vector<>());
        jComboBoxesFK.get(1).add(0);
        jComboBoxesFK.get(3).add(2);

        jComboBoxesFK.get(4).add(0);
        jComboBoxesFK.get(4).add(3);

        jComboBoxesFK.get(5).add(2);

        jComboBoxesFK.get(6).add(1);
        jComboBoxesFK.get(6).add(4);
        jComboBoxesFK.get(6).add(5);
        jComboBoxesFK.get(7).add(6);



    }




    private static void initPassportsModelColumns(){
        models.get(0).addColumn("Идентификатор паспорта");
        models.get(0).addColumn("Имя");
        models.get(0).addColumn("Фамилия");
        models.get(0).addColumn("Отчество");
        models.get(0).addColumn("Серия паспорта");
        models.get(0).addColumn("Номер паспорта");
        models.get(0).addColumn("Пол");
        models.get(0).addColumn("Адрес");
        models.get(0).addColumn("Дата рождения");
        models.get(0).addColumn("Место рождения");
        models.get(0).addColumn("Дата выдачи");
        models.get(0).addColumn("Место выдачи");
        models.get(0).addColumn("Воинская деятельность");
        models.get(0).addColumn("Семейное положение");
        models.get(0).addColumn("Действителен ли паспорт");
    }

    private static void initClientsModelColumns(){
        models.get(1).addColumn("Идентификатор клиента");
        models.get(1).addColumn("Идентификатор паспорта");
        models.get(1).addColumn("Адрес проживания клиента");
        models.get(1).addColumn("Номер телефона клиента");
        models.get(1).addColumn("Адрес электронной почты клиента");
        models.get(1).addColumn("Пароль клиента для входа в систему");
    }

    private static void initCurrencyModelColumns(){
        models.get(2).addColumn("Идентификатор валюты");
        models.get(2).addColumn("код по ISO 4217");
        models.get(2).addColumn("Название валюты");
    }

    private static void initPositionModelColumns(){
        models.get(3).addColumn("Идентификатор должности");
        models.get(3).addColumn("Идентификатор валюты");
        models.get(3).addColumn("Название должности");
        models.get(3).addColumn("Размер заработной платы должности");
    }

    private static void initEmployeeModelColumns(){
        models.get(4).addColumn("Идентификатор работника");
        models.get(4).addColumn("Идентификатор паспорта");
        models.get(4).addColumn("Идентификатор должности");
        models.get(4).addColumn("Адрес электронной почты работника");
        models.get(4).addColumn("Номер телефона работника");
        models.get(4).addColumn("Адрес проживания работника");
        models.get(4).addColumn("Пароль работника для входа в систему");
        models.get(4).addColumn("Дата приёма работника на работу");
        models.get(4).addColumn("Дата увольнения работника");

    }

    private static void initDepositModelColumns(){
        models.get(5).addColumn("Идентификатор вклада");
        models.get(5).addColumn("Идентификатор валюты");
        models.get(5).addColumn("Название вклада");
        models.get(5).addColumn("Процентная ставка вклада");
        models.get(5).addColumn("Минимальный срок вклада в месяцах");
        models.get(5).addColumn("Минимальная сумма вклада");
        models.get(5).addColumn("Условия вклада");
    }

    private static void initContractModelColumns(){

    }

    private static void initHistoryModelColumns(){

    }

    private static void initPassportLabels(){
        textLabels.get(0).add("Идентификатор паспорта");
        textLabels.get(0).add("Имя (Обязательно)");
        textLabels.get(0).add("Фамилия (Обязательно)");
        textLabels.get(0).add("Отчество");
        textLabels.get(0).add("Серия паспорта (Обязательно)");
        textLabels.get(0).add("Номер паспорта (Обязательно)");
        textLabels.get(0).add("Пол (м/ж) (Обязательно)");
        textLabels.get(0).add("Адрес (Обязательно)");
        textLabels.get(0).add("Дата рождения (ГГГГ-ММ-ДД) (Обязательно)");
        textLabels.get(0).add("Место рождения (Обязательно)");
        textLabels.get(0).add("Дата получения (ГГГГ-ММ-ДД) (Обязательно)");
        textLabels.get(0).add("Место получения (Обязательно)");
        textLabels.get(0).add("Воинская детятельность");
        textLabels.get(0).add("Семейное положение");
        textLabels.get(0).add("Действителен ли паспорт (да/нет) (Обязательно)");
    }

    private static void initClientTextLabels(){
        textLabels.get(1).add("Идентификатор клиента");
        textLabels.get(1).add("Адрес проживания клиента (Обязательно)");
        textLabels.get(1).add("Номер телефона клиента (Обязательно)");
        textLabels.get(1).add("Адрес электронной почты клиента (Обязательно)");
        textLabels.get(1).add("Пароль для входа в систему клиента (Обязательно)");
    }

    private static void initClientBoxLabels(){
        boxLabels.get(1).add("Идентификатор паспорта");
    }


    private static void initCurrencyLabels(){
        textLabels.get(2).add("Идентификатор валюты");
        textLabels.get(2).add("Идентификатор валюты по ISO 4217 (Обязательно)");
        textLabels.get(2).add("Название валюты (Обязательно)");
    }

    public static void init() throws SQLException {


        initJFramesConstants();

        textLabels = new Vector<>();
        boxLabels = new Vector<>();

        models = new Vector<>();
        for(int i = 0; i != tablesNumber; i++) {
            models.add(new AppDefaultTableModel());
            textLabels.add(new Vector<>());
            boxLabels.add(new Vector<>());
        }


        initPassportsModelColumns();
        initClientsModelColumns();
        initCurrencyModelColumns();


        DatabaseConnection.refreshModel(0);
        DatabaseConnection.refreshModel(1);
        DatabaseConnection.refreshModel(2);

        initPassportLabels();


        initClientTextLabels();
        initClientBoxLabels();



        initCurrencyLabels();

        passportsModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };



        passportsModel.addColumn("Идентификатор");
        passportsModel.addColumn("Имя");
        passportsModel.addColumn("Фамилия");
        passportsModel.addColumn("Отчество");
        passportsModel.addColumn("Серия");
        passportsModel.addColumn("Номер");
        passportsModel.addColumn("Пол");
        passportsModel.addColumn("Адрес");
        passportsModel.addColumn("Дата рождения");
        passportsModel.addColumn("Место рождения");
        passportsModel.addColumn("Дата выдачи");
        passportsModel.addColumn("Место выдачи");
        passportsModel.addColumn("Воинская деятельность");
        passportsModel.addColumn("Семейное положение");
        passportsModel.addColumn("Действителен ли паспорт");


    }





    public static DefaultTableModel getPassportsModel() {
        return passportsModel;
    }

    public static void setPassportsModel(DefaultTableModel passportsModel) {
        State.passportsModel = passportsModel;
    }

    private static Vector<Vector<String>> clients;
    private static Vector<Vector<String>> employees;
    private static Vector<Vector<String>> positions;

    public static Vector<Vector<String>> getPositions() {
        return positions;
    }

    public static void setPositions(Vector<Vector<String>> positions) {
        State.positions = positions;
    }

    public static Vector<Vector<String>> getEmployees() {
        return employees;
    }

    public static void setEmployees(Vector<Vector<String>> employees) {
        State.employees = employees;
    }

    public static Vector<String> getClientData() {
        return clientData;
    }

    public static void setClientData(Vector<String> clientData) {
        State.clientData = clientData;
    }

    public static Vector<String> getEmployeeData() {
        return employeeData;
    }

    public static void setEmployeeData(Vector<String> employeeData) {
        State.employeeData = employeeData;
    }

    public static Vector<String> getAdminData() {
        return adminData;
    }

    public static void setAdminData(Vector<String> adminData) {
        State.adminData = adminData;
    }

    public static void setClients(Vector<Vector<String>> clients) {
        State.clients = clients;
    }



    public static Vector<Vector<String>> getPassports() {
        return passports;
    }

    public static Vector<Vector<String>> getClients() {
        return clients;
    }

    public static void setPassports(Vector<Vector<String>> passports) {
        State.passports = passports;

    }
}