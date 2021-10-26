package ru.ssau.tk.tgcvso.practice.tgbot;

public final class Consts {
    static final String POSITIVE_ANSWER = "Выберите пункт из меню";
    static final String NEGATIVE_ANSWER = "Ну и иди отсюда\uD83D\uDE21";
    static final String TEST = "/start";
    static final String HELP = "Я помогу тебе найти текст любой песни с сайта https://genius.com \uD83E\uDD17\n\nСоздатель бота: @verystupidowl";
    static final String SONG_EXAMPLE = "Введите исполнителя и название песни на английском, чтобы получить текст определённой песни\nПример: Xxxtentacion jocelyn flores\n" +
            "Или имя исполнителя на английском со звёздочкой, чтобы получить список самых популярных песен";
    static final String RULES = "Программист, создавший меня немного глупый, поэтому я обладаю очень ограниченным функционалом\n" +
            "Я работаю только с английскими названиями\n(Не написанные транслитом, а именно на английском языке) " +
            "Даже у русских песен. И без точек\nПример: \nЧтобы получить текст песни ЛСП - Монетка, нужно будет написать lsp coin\n" +
            "sted.d записки на теле - stedd notes on the body и тд\nЧтобы получить список самых популярных песен исполнителя, введите имя " +
            "исполнителя со звёздочкой в конце\nПример:xxxtentacion*,  Travis Scott*\n" +
            "Регистр букв неважен";
    static final String DEFAULT_TEXT = "Не знаю такого\uD83D\uDE14\nПроверьте правильность написанного.";
    static final String WITHOUT_SONGS = "К сожалению, у этого исполнителя нет собственных популярных песен\uD83D\uDE22" +
            "Попробуйте другого или введите название определенной песни";
    static final String SERVER_IS_NOT_RESPONDING = "Сервер не отвечает, повторите попытку";
}
