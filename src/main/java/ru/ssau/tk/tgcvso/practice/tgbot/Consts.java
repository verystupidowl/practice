package ru.ssau.tk.tgcvso.practice.tgbot;

public final class Consts {
    public static final String POSITIVE_ANSWER = "Выберите пункт из меню";
    public static final String NEGATIVE_ANSWER = "Ну и иди отсюда\uD83D\uDE21";
    public static final String TEST = "/start";
    public static final String HELP = "Я помогу тебе найти текст любой песни с сайта https://genius.com \uD83E\uDD17\n\nСоздатель бота: @SneakyThrowss\nВторой проект: @Covid19_get_information_bot";
    public static final String SONG_EXAMPLE = "Введите исполнителя и название песни на английском, чтобы получить текст определённой песни\nПример: Xxxtentacion jocelyn flores\n" +
            "Или имя исполнителя на английском со звёздочкой, чтобы получить список самых популярных песен";
    public static final String RULES = "Программист, создавший меня немного глупый, поэтому я обладаю очень ограниченным функционалом\n" +
            "Я работаю только с английскими названиями\n(Не написанные транслитом, а именно на английском языке) " +
            "Даже у русских песен. \nПример: \nЧтобы получить текст песни ЛСП - Тело, нужно будет написать LSP body\n" +
            "sted.d записки на теле - sted.d notes on the body и тд\nЧтобы получить список самых популярных песен исполнителя, введите имя " +
            "исполнителя со звёздочкой в конце\nПример:xxxtentacion*, Travis Scott*\n" +
            "Регистр букв неважен\nЧтобы получить сведения о песне, нажмите на всплывающую кнопку под сообщением с текстом, а после на сообщение, отправленное ботом.\n" +
            "Приятного использования\uD83D\uDE0A";
    public static final String DEFAULT_TEXT = "Не знаю такого\uD83D\uDE14\nПроверьте правильность написанного.";
    public static final String WITHOUT_SONGS = "К сожалению, у этого исполнителя нет собственных популярных песен\uD83D\uDE22" +
            "Попробуйте другого или введите название определенной песни";
    public static final String SERVER_IS_NOT_RESPONDING = "Сервер не отвечает, повторите попытку позже";
}
