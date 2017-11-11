import com.level.entity.Seria;
import com.level.factory.Factory;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        Seria seria = new Seria();
        seria.setSeriaName("Assassins creed");
        seria.setImage("images\\ac.jpeg");
        seria.setShortDescription("Материал из Википедии — свободной энциклопедии\n" +
                "Assassin’s Creed (с англ. — «Кредо ассасина») — серия\n" +
                "мультиплатформенных компьютерных игр в жанре приключенческого\n" +
                "боевика, разработанная компанией Ubisoft Montreal для PlayStation 3,\n" +
                "PlayStation 4, Xbox 360, Xbox One, Windows и других. Игра издается\n" +
                "французской компанией Ubisoft. Первая игра вышла в 2007 году и получила\n" +
                "несколько продолжений\n" +
                "[1]\n" +
                ".\n" +
                "Действие игр серии Assassin’s Creed происходит в разные эпохи в истории\n" +
                "человечества и в разных странах, на фоне различных исторических событий,\n" +
                "таких как Третий крестовый поход или Великая французская революция, с\n" +
                "добавлением тем научной фантастики и криптоистории. Объединяющий\n" +
                "сюжет, затрагивающий в том числе и XXI век, рассказывает о многовековой\n" +
                "тайной борьбе двух организаций — тамплиеров и ассасинов. Большинство игр\n" +
                "серии представляет собой action-adventure с открытым миром, где особое\n" +
                "внимание уделяется скрытому перемещению и паркуру. Согласно отчёту,\n" +
                "опубликованному Ubisoft в сентябре 2016 года, совокупные продажи игр серии\n" +
                "Assassin’s Creed составили более 100 миллионов копий\n" +
                "[2]\n" +
                ".\n");

        Factory<Seria> seriaFactory = new Factory<Seria>();
        seriaFactory.getInstance().getCommunDAO().addObject(seria);

    }
}
