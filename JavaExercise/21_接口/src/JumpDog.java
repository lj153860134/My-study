class JumpDog extends Dog implements Jumpping {
    public JumpDog() {
    }

    public JumpDog(String name, int age) {
        super(name, age);
    }

    @Override
    public void jump() {
        System.out.println("Dog jump");
    }
}
