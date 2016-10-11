// Libraries
import {NativeModules} from 'react-native';


const {RNInstabugSDK} = NativeModules;


class Instabug {

  static invoke() {
    return RNInstabugSDK.invoke();
  }

}


export default Instabug;
