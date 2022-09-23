import FacebookIcon from '@mui/icons-material/Facebook';
import TwitterIcon from '@mui/icons-material/Twitter';
import InstagramIcon from '@mui/icons-material/Instagram';
import YouTubeIcon from '@mui/icons-material/YouTube';
function Footer (){

    return(
        <footer class="footer-distributed">                        
            <div class="footer-left">
                <h3>Sentidos<span>logo</span></h3>
                <p class="footer-links">
                    <a href="#">Home</a>
                    ·
                    <a href="#">Blog</a>
                    ·
                    <a href="#">Pricing</a>
                    ·
                    <a href="#">About</a>
                    ·
                    <a href="#">Faq</a>
                    ·
                    <a href="#">Contact</a>
                </p>
                <p class="footer-company-name">Sentidos © 2022</p>
                <p class="footer-company-name">Desarrollado por SysTech</p>
                <div class="footer-icons">
                    <a  href={"https://www.facebook.com"} target="_blank" style={{"backgroundColor":"transparent"}}>
                    <FacebookIcon  style={{"fontSize":"60px", "cursor":"pointer","color":"#4267B2"}} />
                    </a>

                    <a  href={"https://www.twitter.com"} target="_blank" style={{"backgroundColor":"transparent","marginLeft":"20px"}}>
                        <TwitterIcon  style={{"fontSize":"60px", "cursor":"pointer","color":"#1DA1F2"}}/>
                    </a>

                    <a  href={"https://www.instagram.com"} target="_blank" style={{"backgroundColor":"transparent","marginLeft":"20px"}}>
                    <InstagramIcon  style={{"fontSize":"60px", "cursor":"pointer","color":"#C13584"}} />
                    </a>
                    
                    <a  href={"https://www.youtube.com"} target="_blank" style={{"backgroundColor":"transparent","marginLeft":"20px"}}>
                    <YouTubeIcon  style={{"fontSize":"60px", "cursor":"pointer","color":"#FF0000"}} />  
                    </a>    
                </div>
            </div>

            <div class="footer-right">
                <p>Contactanos</p>
                <form action="#" method="post">
                    <input class="emailInput" type="text" name="email" placeholder="Email"/>
                    <textarea name="message" placeholder="Message"></textarea>
                    <button>Send</button>
                </form>
            </div>
		</footer>
    )
}

export default Footer;