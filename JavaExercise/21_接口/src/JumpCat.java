 class JumpCat extends Cat implements Jumpping {
     public JumpCat() {
     }

     public JumpCat(String name, int age) {
         super(name, age);
     }

     @Override
    public void jump() {
        System.out.println("Cat jump");
    }
}
