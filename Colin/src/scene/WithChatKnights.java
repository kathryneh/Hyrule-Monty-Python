package scene;

import input.IndexedStrings;
import parts.ChatKnightParts;
import parts.ChatKnights;
import graphics.Point;

public class WithChatKnights extends WithoutKnights implements ScenesWithChatKnights{
	ChatKnightParts[] k;
	public WithChatKnights(String[] n,IndexedStrings[][] a) {
		super(n[0]);
		k=new ChatKnights[]{new ChatKnights(new Point(200-2*60,136),new String[]{n[1],n[2]},a[0]),new ChatKnights(new Point(500,136),new String[]{n[3],n[4]},a[1])};
	}
	@Override
	public ChatKnightParts[] getChatKnights(){
		return k;
	}
}
