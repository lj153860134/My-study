package cn.lingjian_2;

/**
 * @author lingjian
 * @date 2019/10/23 - 10:00 上午
 */
public class DogFactory implements Factory {
    @Override
    public Animal creatAnimal() {
        return new Dog();
    }
}
