package comando;

import library.Dados;

public interface Command {
	public Object execute(Dados dado);
}
