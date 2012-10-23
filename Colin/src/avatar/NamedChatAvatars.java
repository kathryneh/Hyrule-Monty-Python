package avatar;

import equipment.AlignedChatHistory;

public interface NamedChatAvatars extends NamedMovables{
	public AlignedChatHistory getChat();
	public void removeL();
	public void removeF();
}
