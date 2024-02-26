const quesJSON = [
  {
    correctAnswer: 'Three ',
    options: ['Two', 'Three ', 'Four', 'Five'],
    question:
      "How many pieces of bun are in a Mcdonald's Big Mac?",
  },
  {
    correctAnswer: 'L. Frank Baum',
    options: [
      'Suzanne Collins',
      'James Fenimore Cooper',
      'L. Frank Baum',
      'Donna Leon',
    ],
    question:
      "Which author wrote 'The Wonderful Wizard of Oz'?",
  },
  {
    correctAnswer: 'Atlanta United',
    options: [
      'Atlanta United',
      'Atlanta Impact',
      'Atlanta Bulls',
      'Atlanta Stars',
    ],
    question:
      'Which of these is a soccer team based in Atlanta?',
  },
  {
    correctAnswer: 'A Nanny',
    options: [
      'A Sow',
      'A Lioness',
      'A Hen',
      'A Nanny',
    ],
    question: 'A female goat is known as what?',
  },
  {
    correctAnswer: 'P. L. Travers',
    options: [
      'J. R. R. Tolkien',
      'P. L. Travers',
      'Lewis Carroll',
      'Enid Blyton',
    ],
    question:
      "Which author wrote 'Mary Poppins'?",
  },
];
   
    //fetch
    const questionEl=document.getElementById('question');
    const scoreEl=document.getElementById('score');
    const optionEl=document.getElementById('options');
    let score=0;
    let curr=0; 



    //question render
    function renderQues(){
    const{correctAnswer,options,question}=quesJSON[curr];

    //manipulating
    scoreEl.textContent=`score  ${score}`;
    questionEl.textContent=question;


    //suffle function
    function shuffle(options){
      for(let i=options.length-1;i>=0;i--){
        let j=Math.floor(Math.random()*i+1);
        [options[i],options[j]]=[options[j],options[i]];
      }
      return options;
    }
    for(let xxx of shuffle(options)){
      const op=document.createElement('button');
      op.textContent=xxx;
      optionEl.append(op);

      //event handling
      op.addEventListener('click',()=>{
        if(op.textContent===correctAnswer){
          score+=1;
          scoreEl.textContent=`score  ${score}`;

        }else{
          score-=1;
          scoreEl.textContent=`score  ${score}`;
        }
        if(curr==quesJSON.length){
          questionEl.textContent='Quiz Finished';
          optionEl.textContent='';
        }else{
          curr++;
          renderQues();
        }
      });
    }

    
  }
  document.getElementById('next').addEventListener('click',()=>{
    if(curr==quesJSON.length-1){
      questionEl.textContent='Quiz Finished';
      optionEl.textContent='';
      document.getElementById('next').remove();
    }else{
      optionEl.textContent='';
      curr++;
      renderQues();
    }
  });
  
  
  renderQues();

    //score footer


    
    



