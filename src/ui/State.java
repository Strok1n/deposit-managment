package ui;

import db.DatabaseConnection;
import util.AppDefaultTableModel;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.*;

public class State {

    private static final int tablesNumber = 8;
    public static final Vector<String> tableNames = new Vector<>(Arrays.asList("passport", "client", "currency",
                    "position", "employee", "deposit", "contract", "history"));


    public static Vector<Vector<String>> dbTableColumns;


    static{
       dbTableColumns = new Vector<>();
        for(int i = 0; i != tablesNumber; i++)
            dbTableColumns.add(new Vector<>());


     //   dbTableColumns.get(1).add("id");
      //  dbTableColumns.get(1).add("id_passport");
     //   dbTableColumns.get(1).add("address");
      //  dbTableColumns.get(1).add("email");
      //  dbTableColumns.get(1).add("phone");
       // dbTableColumns.get(1).add("pwd_hash");
    }


    public static Vector<DefaultTableModel> models;

    public static Vector<Vector<String>> textLabels;
    public static Vector<Vector<String>> boxLabels;

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
        jComboBoxesFK = new Vector<>();
        for (int i = 0; i != tablesNumber; i++)
            jComboBoxesFK.add(new Vector<>());
        jComboBoxesFK.get(1).add(0);

        jComboBoxesFK.get(3).add(2);

        jComboBoxesFK.get(4).add(0);
        jComboBoxesFK.get(4).add(3);

        jComboBoxesFK.get(5).add(2);

        jComboBoxesFK.get(6).add(5);
        jComboBoxesFK.get(6).add(1);
        jComboBoxesFK.get(6).add(4);

        jComboBoxesFK.get(7).add(6);
    }












    private static void initPassportDbColumns(){
        dbTableColumns.get(0).add("id");
        dbTableColumns.get(0).add("first_name");
        dbTableColumns.get(0).add("last_name");
        dbTableColumns.get(0).add("patronymic");
        dbTableColumns.get(0).add("series");
        dbTableColumns.get(0).add("number");
        dbTableColumns.get(0).add("gender");
        dbTableColumns.get(0).add("address");
        dbTableColumns.get(0).add("birth_date");
        dbTableColumns.get(0).add("birth_place");
        dbTableColumns.get(0).add("issue_date");
        dbTableColumns.get(0).add("issue_place");
        dbTableColumns.get(0).add("military_duty");
        dbTableColumns.get(0).add("marital_status");
        dbTableColumns.get(0).add("is_valid");
    }

    private static void initPassportUiTableColumns(){
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

    private static void initPassportCrudTextLabels(){
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
        textLabels.get(0).add("Дата выдачи (ГГГГ-ММ-ДД) (Обязательно)");
        textLabels.get(0).add("Место выдачи (Обязательно)");
        textLabels.get(0).add("Воинская детятельность");
        textLabels.get(0).add("Семейное положение");
        textLabels.get(0).add("Действителен ли паспорт (да/нет) (Обязательно)");
    }

    private static void initPassportCrudBoxLabels(){}

    private static void initClientDbColumns(){
        dbTableColumns.get(1).add("id");
        dbTableColumns.get(1).add("id_passport");
        dbTableColumns.get(1).add("phone");
        dbTableColumns.get(1).add("email");
        dbTableColumns.get(1).add("address");
        dbTableColumns.get(1).add("pwd_hash");
    }

    private static void initClientUiTableColumns(){
        models.get(1).addColumn("Идентификатор клиента");
        models.get(1).addColumn("Идентификатор паспорта");
        models.get(1).addColumn("Номер телефона клиента");
        models.get(1).addColumn("Адрес электронной почты клиента");
        models.get(1).addColumn("Адрес проживания клиента");
        models.get(1).addColumn("Хэш пароля клиента для входа в систему");
    }

    private static void initClientCrudTextLabels(){
        textLabels.get(1).add("Идентификатор клиента");
        textLabels.get(1).add("Номер телефона клиента (Обязательно)");
        textLabels.get(1).add("Адрес электронной почты клиента (Обязательно)");
        textLabels.get(1).add("Адрес проживания клиента (Обязательно)");
        textLabels.get(1).add("Пароль клиента для входа в систему (Обязательно)");
    }

    private static void initClientCrudBoxLabels(){
        boxLabels.get(1).add("Идентификатор паспорта (Обязательно)");
    }

    private static void initCurrencyDbColumns(){
        dbTableColumns.get(2).add("id");
        dbTableColumns.get(2).add("iso_key");
        dbTableColumns.get(2).add("name");
    }

    private static void initCurrencyUiTableColumns(){
        models.get(2).addColumn("Идентификатор валюты");
        models.get(2).addColumn("Идентификатор валюты по стандарту ISO 4217");
        models.get(2).addColumn("Название валюты");
    }

    private static void initCurrencyCrudTextLabels(){
        textLabels.get(2).add("Идентификатор валюты");
        textLabels.get(2).add("Идентификатор валюты по стандарту ISO 4217 (Обязательно)");
        textLabels.get(2).add("Название валюты (Обязательно)");
    }

    private static void initCurrencyCrudBoxLabels(){}

    private static void initPositionDbColumns(){
        dbTableColumns.get(3).add("id");
        dbTableColumns.get(3).add("id_currency");
        dbTableColumns.get(3).add("name");
        dbTableColumns.get(3).add("salary");
    }

    private static void initPositionUiTableColumns(){
        models.get(3).addColumn("Идентификатор должности");
        models.get(3).addColumn("Идентификатор валюты");
        models.get(3).addColumn("Название должности");
        models.get(3).addColumn("Размер заработной платы должности");
    }

    private static void initPositionCrudTextLabels(){
        textLabels.get(3).add("Идентификатор должности");
        textLabels.get(3).add("Название должности (Обязательно)");
        textLabels.get(3).add("Размер заработной платы (Обязательно)");
    }

    private static void initPositionCrudBoxLabels(){
        boxLabels.get(3).add("Идентификатор валюты (Обязательно)");
    }

    private static void initEmployeeDbColumns(){
        dbTableColumns.get(4).add("id");
        dbTableColumns.get(4).add("id_passport");
        dbTableColumns.get(4).add("id_position");
        dbTableColumns.get(4).add("employment_date");
        dbTableColumns.get(4).add("dismissal_date");
        dbTableColumns.get(4).add("phone");
        dbTableColumns.get(4).add("email");
        dbTableColumns.get(4).add("address");
        dbTableColumns.get(4).add("pwd_hash");
    }

    private static void initEmployeeUiTableColumns(){
        models.get(4).addColumn("Идентификатор работника");
        models.get(4).addColumn("Идентификатор паспорта");
        models.get(4).addColumn("Идентификатор должности");
        models.get(4).addColumn("Дата приёма работника на работу");
        models.get(4).addColumn("Дата увольнения работника");
        models.get(4).addColumn("Номер телефона работника");
        models.get(4).addColumn("Адрес электронной почты работника");
        models.get(4).addColumn("Адрес проживания работника");
        models.get(4).addColumn("Хэш пароля работника для входа в систему");
    }

    private static void initEmployeeCrudTextLabels(){
        textLabels.get(4).add("Идентификатор работника");
        textLabels.get(4).add("Дата приёма работника на работу (Обязательно)");
        textLabels.get(4).add("Дата увольнения работника");
        textLabels.get(4).add("Номер телефона работника (Обязательно)");
        textLabels.get(4).add("Адрес электронной почты работника (Обязательно)");
        textLabels.get(4).add("Адрес проживания работника (Обязательно)");
        textLabels.get(4).add("Пароль работника для входа в систему (Обязательно)");
    }

    private static void initEmployeeCrudBoxLabels(){
        boxLabels.get(4).add("Идентификатор паспорта (Обязательно)");
        boxLabels.get(4).add("Идентификатор должности (Обязательно)");
    }

    private static void initDepositDbColumns(){
        dbTableColumns.get(5).add("id");
        dbTableColumns.get(5).add("id_currency");
        dbTableColumns.get(5).add("name");
        dbTableColumns.get(5).add("term_min_months");
        dbTableColumns.get(5).add("sum_min");
        dbTableColumns.get(5).add("percent");
        dbTableColumns.get(5).add("conditions");
    }

    private static void initDepositUiTableColumns(){
        models.get(5).addColumn("Идентификатор вклада");
        models.get(5).addColumn("Идентификатор валюты");
        models.get(5).addColumn("Название вклада");
        models.get(5).addColumn("Процентная ставка вклада");
        models.get(5).addColumn("Минимальный срок вклада в месяцах");
        models.get(5).addColumn("Минимальная сумма вклада");
        models.get(5).addColumn("Условия вклада");
    }

    private static void initDepositCrudTextLabels(){
        textLabels.get(5).add("Идентификатор вклада");
        textLabels.get(5).add("Название вклада (Обязательно)");
        textLabels.get(5).add("Процентная ставка вклада (Обязательно)");
        textLabels.get(5).add("Минимальный срок вклада в месяцах (Обязательно)");
        textLabels.get(5).add("Минимальная сумма вклада (Обязательно)");
        textLabels.get(5).add("Условия вклада (Обязательно)");
    }

    private static void initDepositCrudBoxLabels(){
        boxLabels.get(5).add("Идентификатор валюты (Обязательно)");
    }

    private static void initContractDbColumns(){
        dbTableColumns.get(6).add("id");
        dbTableColumns.get(6).add("id_deposit");
        dbTableColumns.get(6).add("id_client");
        dbTableColumns.get(6).add("id_employee");
        dbTableColumns.get(6).add("sum");
        dbTableColumns.get(6).add("sum_return");
        dbTableColumns.get(6).add("term_months");
        dbTableColumns.get(6).add("date_start");
        dbTableColumns.get(6).add("date_return");
        dbTableColumns.get(6).add("is_money_returned");
    }

    private static void initContractUiTableColumns(){
        models.get(6).addColumn("Идентификатор контракта");
        models.get(6).addColumn("Идентификатор вклада");
        models.get(6).addColumn("Идентификатор клиента");
        models.get(6).addColumn("Идентификатор работника");
        models.get(6).addColumn("Сумма вложенная клиентом");
        models.get(6).addColumn("Сумма возврата");
        models.get(6).addColumn("Срок контракта в месяцах");
        models.get(6).addColumn("Дата начала действия контракта");
        models.get(6).addColumn("Дата возврата суммы контракта клиенту");
        models.get(6).addColumn("Деньги возвращены клиенту");
    }

    private static void initContractCrudTextLabels(){
        textLabels.get(6).add("Идентификатор контракта");
        textLabels.get(6).add("Вложенная клиентом сумма (Обязательно)");
        textLabels.get(6).add("Сумма возврата");
        textLabels.get(6).add("Срок действия контракта в месяцах (Обязательно)");
        textLabels.get(6).add("Дата начала действия контракта (Обязательно)");
        textLabels.get(6).add("Дата возврата суммы клиенту");
        textLabels.get(6).add("Деньги возвращены клиенту");
    }

    private static void initContractCrudBoxLabels(){
        boxLabels.get(6).add("Идентификатор вклада (Обязательно)");
        boxLabels.get(6).add("Идентификатор клиента (Обязательно)");
        boxLabels.get(6).add("Идентификатор сотрудника (Обязательно)");
    }

    private static void initHistoryDbColumns(){
        dbTableColumns.get(7).add("id");
        dbTableColumns.get(7).add("id_contract");
        dbTableColumns.get(7).add("sum");
        dbTableColumns.get(7).add("date");
    }

    private static void initHistoryUiTableColumns(){
        models.get(7).addColumn("Идентификатор истории");
        models.get(7).addColumn("Идентификатор контракта");
        models.get(7).addColumn("Сумма снятия");
        models.get(7).addColumn("Дата и время снятия");
    }

    private static void initHistoryCrudTextLabels(){
        textLabels.get(7).add("Идентификатор истории");
        textLabels.get(7).add("Сумма снятия (Обязательно)");
        textLabels.get(7).add("Дата снятия (Обязательно)");
    }

    private static void initHistoryCrudBoxLabels(){
        boxLabels.get(7).add("Идентификатор контракта (Обязательно)");
    }



    public static void init() throws SQLException {
        textLabels = new Vector<>();
        boxLabels = new Vector<>();
        models = new Vector<>();

        for(int i = 0; i != tablesNumber; i++) {
            models.add(new AppDefaultTableModel());
            textLabels.add(new Vector<>());
            boxLabels.add(new Vector<>());
        }

        initJFramesConstants();

        initPassportDbColumns();
        initPassportUiTableColumns();
        initPassportCrudTextLabels();
        initPassportCrudBoxLabels();

        initClientDbColumns();
        initClientUiTableColumns();
        initClientCrudTextLabels();
        initClientCrudBoxLabels();

        initCurrencyDbColumns();
        initCurrencyUiTableColumns();
        initCurrencyCrudTextLabels();
        initCurrencyCrudBoxLabels();

        initPositionDbColumns();
        initPositionUiTableColumns();
        initPositionCrudTextLabels();
        initPositionCrudBoxLabels();

        initEmployeeDbColumns();
        initEmployeeUiTableColumns();
        initEmployeeCrudTextLabels();
        initEmployeeCrudBoxLabels();

        initDepositDbColumns();
        initDepositUiTableColumns();
        initDepositCrudTextLabels();
        initDepositCrudBoxLabels();

        initContractDbColumns();
        initContractUiTableColumns();
        initContractCrudTextLabels();
        initContractCrudBoxLabels();

        initHistoryDbColumns();
        initHistoryUiTableColumns();
        initHistoryCrudTextLabels();
        initHistoryCrudBoxLabels();

        for (int i = 0; i != tablesNumber; i++)
            DatabaseConnection.refreshModel(i);
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