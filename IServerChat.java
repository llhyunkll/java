package kr.or.ddit.rmichat.inf;

import java.rmi.Remote;
import java.rmi.RemoteException;

// 서버용 인터페이스 ==> 클라이언트가 서버쪽의 메서드를 호출할 때 사용하는 인터페이스
public interface IServerChat extends Remote{
	
	//접속한 클라이언트 정보를 List에 추가하는 메서드 
	public void setClient(IClientChat client) throws RemoteException ; 
	
	public void transMessage(String msg) throws RemoteException ;
	

}
