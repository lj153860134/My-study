class InterfaceTest {
    public static void main(String[] args) {
        JumpCat jc=new JumpCat();
        jc.setName("机器猫");
        jc.setAge(5);
        System.out.println(jc.getName()+"------"+jc.getAge());
        jc.sleep();
        jc.eat();
        jc.jump();

        JumpCat jc1=new JumpCat("加菲猫",8);
        System.out.println(jc1.getName()+"------"+jc1.getAge());
        jc1.sleep();
        jc1.eat();
        jc1.jump();
    }
}
