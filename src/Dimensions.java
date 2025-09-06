

public record Dimensions(double length, double width, double height) {

    //Класс Dimensions (используется для габаритов):
    //В нём будет три поля: «Длина», «Ширина» и «Глубина».
    //Каждый объект Dimensions должен уметь сравнивать себя с другим объектом Dimensions, чтобы ответить на вопрос, можно ли разместить одни габариты в другие.
    //Габариты не могут изменять значения своих полей после создания.

    public static boolean isSmaller(Dimensions inSize, Dimensions outSize) {
//       if ((inSize.length).compareTo(outSize.length) == -1 &&
//               (inSize.width).compareTo(outSize.width) == -1 &&
//               (inSize.height).compareTo(outSize.height) == -1) {
//           return true;
        if (inSize.length < outSize.length && inSize.width < outSize.width && inSize.height < outSize.height) {
            return true;
       } else {
           return false;
       }
    }
}
