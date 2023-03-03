public class Vector2D {
    protected int x;
    protected int y;

    public Vector2D(int x, int y){
        this.x = x;
        this.y = y;
    }

    public double Distance(Vector2D enemy){
        return Math.sqrt((x - enemy.x)^2 + (y - enemy.y)^2);
      };

    // public void SetPos(int posX, int posY){
    //     this.posX = posX;
    //     this.posY = posY;
    // }

    // public int GetPosX(){
    //     return posX;
    // }

    // public int GetPosY(){
    //     return posY;
    // }
}
