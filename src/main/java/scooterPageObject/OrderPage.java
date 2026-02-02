package scooterPageObject;

public class OrderPage {
    //Поле "Имя"
    private final String NAME = "//div[@class='Input_InputContainer__3NykH']//input[contains(@placeholder, '* Имя')]";
    //Поле "Фамилия"
    private final String SURNAME = "//div[@class='Input_InputContainer__3NykH']//input[contains(@placeholder, '* Фамилия')]";
    //Поле "Адрес: куда привезти заказ"
    private final String ADDRESS = "//div[@class='Input_InputContainer__3NykH']//input[contains(@placeholder, '* Адрес')]";
    //Поле "Станция метро
    private final String SUBWAY = "//div[@class='select-search__value']//input[contains(@placeholder, '* Станция метро')]";
    //Поле "Телефон: на него позвонит курьер
    private final String PHONE = "//div[@class='Input_InputContainer__3NykH']//input[contains(@placeholder, '* Телефон')]";
    //Кнопка "Далее"
    private final String NEXT = "//div[@class='Order_NextButton__1_rCA']//button[text()='Далее']";
    //Поле "Когда привезти самокат"
    private final String WHEN = "//div[@class='react-datepicker__input-container']//input[contains(@placeholder, '* Когда привезти')]";
    //Поле "Срок аренды"
    private final String ORDER_TIME = "//div[@class='Dropdown-control']//div[@class='Dropdown-placeholder']";
    //Поле "Цвет самоката" - Черный жемчуг
    private final String BLACK_COLOUR = "//input[@id='black']";
    //Поле "Цвет самоката" - серая безысходность
    private final  String GREY_COLOUR = "//input[@id='grey']";
    //Поле "Комментарий для курьера"
    private final String COMMENT = "//div[@class='Input_InputContainer__3NykH']//input[contains(@placeholder, 'Комментарий')]";
    //Кнопка "Назад"
    private final String BACK_BUTTON = "//div[@class='Order_Buttons__1xGrp']//button[contains(@class, 'Button_Inverted__3IF-i')]";
    //Кнопка "Заказать" верхняя
    private final String UP_ORDER_BUTTON = "//div[@class='Header_Nav__AGCXC']//button[text()='Заказать']";
    //Кнопка "Заказать" нижняя
    private final String DOWN_ORDER_BUTTON = "//div[@class='Order_Buttons__1xGrp']//button[text()='Заказать']";
}
