
public class num286 {

    //BFS
    // class Room{
    //     int x;
    //     int y;
    //     public Room(int x,int y){
    //         this.x=x;
    //         this.y=y;
    //     }
    // }
    // public void wallsAndGates(int[][] rooms) {
    //     if(rooms==null||rooms.length==0||rooms[0].length==0)
    //         return;
    //     Queue<Room> q=new LinkedList<Room>();
    //     int m=rooms.length;
    //     int n=rooms[0].length;
    //     for(int i=0;i<m;i++){
    //         for(int j=0;j<n;j++){
    //             if(rooms[i][j]==0)
    //                 q.add(new Room(i,j));
    //         }
    //     }
    //     int[] dx={0,1,-1,0};
    //     int[] dy={1,0,0,-1};
    //     int dis=0;
    //     while(!q.isEmpty()){
    //         dis++;
    //         int size=q.size();
    //         for(int i=0;i<size;i++){
    //             Room room=q.poll();
    //             for(int k=0;k<4;k++){
    //                 int nx=dx[k]+room.x;
    //                 int ny=dy[k]+room.y;
    //                 if(nx>=0&&nx<m&&ny>=0&&ny<n&&rooms[nx][ny]==Integer.MAX_VALUE){
    //                     rooms[nx][ny]=dis;
    //                     q.add(new Room(nx,ny));
    //                 }
    //             }
    //         }
    //     }
    // }
    
    
    
    
    //DFS
    int[] dx={0,1,-1,0};
    int[] dy={1,0,0,-1};
    int m;
    int n;
    int[][] rooms;
    public void wallsAndGates(int[][] rooms) {
        if(rooms==null||rooms.length==0||rooms[0].length==0)
            return;
        this.rooms=rooms;
        m=rooms.length;
        n=rooms[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rooms[i][j]==0)
                    search(i,j,1);
            }
        }
        
    }
    private void search(int x,int y,int dis){
        for(int k=0;k<4;k++){
            int nx=dx[k]+x;
            int ny=dy[k]+y;
            if(nx>=0&&nx<m&&ny>=0&&ny<n&&rooms[nx][ny]>dis){
                rooms[nx][ny]=dis;
                search(nx,ny,dis+1);
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
