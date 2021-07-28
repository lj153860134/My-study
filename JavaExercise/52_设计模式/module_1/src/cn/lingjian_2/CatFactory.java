package cn.lingjian_2;

/**
 * @author lingjian
 * @date 2019/10/23 - 10:08 上午
 */
public class CatFactory implements Factory {
    @Override
    public Animal creatAnimal() {
        return new Cat();
    }
}
