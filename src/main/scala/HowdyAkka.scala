import akka.actor.{ActorSystem, ActorLogging, Actor, Props}

case object Pint

class Person extends Actor with ActorLogging {
  def receive = {
    case Pint => {
      log.info("\n Alice : Thanks for the pint")
    }
  }
}

object HowdyAkka extends App {
  val system = ActorSystem("howdy-akka")

  val alice = system.actorOf(Props(new Person), "alice")

  System.out.println("\nSending Pint to Alice")
  alice ! Pint
  System.out.println("\nSent Pint to Alice")

  system.shutdown()  
}
