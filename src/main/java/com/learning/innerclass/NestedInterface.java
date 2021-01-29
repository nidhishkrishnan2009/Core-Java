package com.learning.innerclass;

import com.learning.innerclass.Institution.School.StaffRoom;

public class NestedInterface {

	
	public static void main(String[] args) {
		Room room=new Test();
		Room.Almirah almirah=new Test();
		room.openDoor();
		almirah.openAlmirah();
		Institution.School s=new Test();
		s.welcomeSchool();
		Institution.EntranceCentre e=new Test();
		e.welcomeEntranceCentre();
		Institution.TutionCentre t=new Test();
		t.welcomeTuitionCentre();
		
		// Testing class inside a nested interface
		Institution.School.StaffRoom staff=new StaffRoom();
		staff.welcomeStaffRoom();
	}

}

class Test implements Room.Almirah,Room,Institution.School,Institution.EntranceCentre,Institution.TutionCentre {
	
	@Override
	public void openAlmirah() {
		System.out.println("Almirah door opened");
		
	}

	@Override
	public void openDoor() {
		System.out.println("Room door opened");
		
	}

	@Override
	public void welcomeTuitionCentre() {
		System.out.println("Welcome to tuition centre");
		
	}

	@Override
	public void welcomeEntranceCentre() {
		System.out.println("Welcome to entrance centre");
		
	}

	@Override
	public void welcomeSchool() {
		System.out.println("Welcome to school");
		
	}

	
}
interface Room{
	void openDoor();
	interface Almirah {
		void openAlmirah();
	}
/**Compile time error since nested interface can only be public. If no access modifier present compiler will add
 * public modifier implicitly. Actually compiler adds public access modifier and static keyword implicitly to nested interface. 
 * 	
 */
	
//	private interface test1{
//		
//	}
//	
//	protected interface test2{
//		
//	}
}

/**
 * 
 * @author Krishnan
 *Nested interface inside a class supports all kind of access modifiers.
 */
class Institution{
	interface School{
		void welcomeSchool();
		
		//Class inside an interface
		class StaffRoom{
			void welcomeStaffRoom() {
				System.out.println("Welcome to staff room");
			}
		}
	}
	
	/** 
	 * 
	 * @author Krishnan
	 *Compile time error if tried to implement private interface.
	 */
	private interface Office{
		void  welcomeOffice();

	}
	
	protected interface EntranceCentre{
		void welcomeEntranceCentre();
	}
	
	public interface TutionCentre{
		void welcomeTuitionCentre();
	}
	
}