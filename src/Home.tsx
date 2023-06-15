import React, {useState} from 'react';
import {View, StyleSheet, Text, TouchableOpacity} from 'react-native';

export default () => {
  const [result, setResult] = useState<string>('result...');
  const onButtonPress = () => {};
  return (
    <View style={styles.root}>
      <Text style={styles.title}>native barCode Module</Text>
      <TouchableOpacity style={styles.button} onPress={onButtonPress}>
        <Text style={styles.buttonTxt}>Goto Scan</Text>
      </TouchableOpacity>
      <View style={styles.resultContainer}>
        <Text style={styles.resultTxt}>{result}</Text>
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  root: {
    width: '100%',
    height: '100%',
    backgroundColor: 'white',
    flexDirection: 'column',
    alignItems: 'center',
    paddingHorizontal: 16,
  },
  title: {
    fontSize: 30,
    color: '#333',
    fontWeight: 'bold',
    marginTop: 48,
  },
  button: {
    width: 120,
    height: 36,
    backgroundColor: '#2030ff',
    borderRadius: 8,
    justifyContent: 'center',
    alignItems: 'center',
  },
  buttonTxt: {
    fontSize: 16,
    color: 'white',
  },
  resultContainer: {
    width: '100%',
    height: 200,
    borderWidth: 1,
    borderColor: '#999',
    borderRadius: 12,
    borderStyle: 'dashed',
    padding: 20,
    marginTop: 32,
  },
  resultTxt: {
    fontSize: 18,
    color: '#666',
  },
});
